//字段优先级
// const total=13,no=12, cancer=11, gene=10, antigen=9, nucleicAcidExchange=8, aminoAcidExchange=7, hlaAllele=6, length=5, peptide=4, adjuvant=3,journalRef=2,pmid=1,placeholder=0;
 Search_rownum = 1;
// var mainKey = '';
//主搜索框绑定回车
$("input[id=Search_input_fuzzy]").keypress(function(e){
    var eCode = e.keyCode ? e.keyCode : e.which ? e.which : e.charCode;
    if (eCode == 13){
        Search_mainSearch();
    }
})

layui.use('form', function(){
    var form = layui.form;

    //监听提交
    // form.on('submit(formDemo)', function(data){
    //     layer.msg(JSON.stringify(data.field));
    //     return false;
    // });
    //监听select
    form.on('select(lay_Search_sel_Fields)', function(data){
        var input = data.othis.parent().parent().parent().find("input[name='title']");
        if (data.value == "HLA/MHC Allele"){
            //找到旁边的input 增加autocomplete
            Search_bind_autocomplete(input ,true);
            //修改默认的提示信息
            Search_ModifyDefaultWord(input,"example：HLA-A*02:01");
        }else{
            //下拉菜单不是HLA/MHC Allele 删除autocomplete
            Search_bind_autocomplete(input,false);
            //修改默认的提示信息
            Search_ModifyDefaultWord(input,"input your keyword");
        }
        layui.use('form', function() {
            var form = layui.form; //只有执行了这一步，部分表单元素才会自动修饰成功
            form.render();
        });
    });

    form.on('submit(contact_submit)', function(data){
        contact_SendMessage();
    });
});
layui.use('element', function(){
    var element = layui.element;

    //一些事件监听
    // element.on('tab(demo)', function(data){
    //     console.log(data);
    // });
});

function Search_ModifyDefaultWord(selector,defalutWord) {
    selector.attr('placeholder',defalutWord);
}

function ShowLoading(type) {
    if (type == "show"){
        $.busyLoadFull("show", {fontawesome: "fa fa-spinner fa-spin fa-3x fa-fw" });
    }else if (type == "hide"){
        $.busyLoadFull("hide");
    }
}
function Search_mainSearch() {
    var strkey = $("#Search_input_fuzzy").val();
    if(!(strkey == "" || strkey == null || strkey == undefined)) {
        //设置cookie
        var JsonParam = {
            type: "fuzzy",
            key: $("#Search_input_fuzzy").val()
        };
        var strParam = JSON.stringify(JsonParam);
        $.cookie('param',strParam);
        //跳转
        window.location.href="/bic/html/search_data.do";
    }
    return;
}

function  del(id) {
    $("#Search_row_"+id).remove();
}
function Search_AddRow() {
    var html_bar ="  <div id='Search_row_"+Search_rownum+"' >"+
        "                <div class=\"layui-inline Search_layui_inline_1\">"+
        "                    <form class=\"layui-form\" action=\"\">"+
        "                        <select name=\"Search_sel_Conjunction\" lay-verify=\"\" lay-search>"+
        "                            <option value=\"AND\" selected>AND</option>"+
        "                            <option value=\"OR\">OR</option>"+
        "                            <option value=\"NOT\">NOT</option>"+
        "                        </select>"+
        "                    </form>"+
        "                 </div>"+
        "                <div class=\"layui-inline Search_layui_inline_2\">"+
        "                    <form class=\"layui-form\" action=\"\">"+
        "                        <select name=\"Search_sel_Fields\" lay-verify=\"\" lay-search lay-filter=\"lay_Search_sel_Fields\">"+
        "                            <option value=\"Cancer\" selected>Cancer</option>"+
        "                            <option value=\"Gene\">Gene</option>"+
        // "                            <option value=\"Antigen\">Antigen</option>"+
        // "                            <option value=\"Nucleic acid exchange\">Nucleic acid exchange</option>"+
        // "                            <option value=\"Amino acid exchange\">Amino acid exchange</option>"+
        "                            <option value=\"HLA/MHC Allele\">HLA/MHC Allele</option>"+
        "                            <option value=\"Length\">Length</option>"+
        "                            <option value=\"Peptide\">Peptide</option>"+
        // "                            <option value=\"Adjuvant\">Adjuvant</option>"+
        // "                            <option value=\"Journal Ref\">Journal Ref</option>"+
        // "                            <option value=\"PMID\">PMID</option>"+
        "                        </select>"+
        "                    </form>"+
        "                </div>"+
        "                <div class=\"layui-inline Search_layui_inline_3\">"+
        "                    <input type=\"text\" name=\"title\" placeholder=\"input your keyword\" autocomplete=\"off\" class=\"layui-input nput_exact_bar\">"+
        "                </div>"+
        "                <div class=\"layui-inline Search_layui_inline_4\">"+
        "                    <div class=\"layui-btn-group\">"+
        "                        <button onclick='del("+Search_rownum+")' class=\"layui-btn layui-btn-primary layui-btn-sm\" id='Search_btn_delrow_"+Search_rownum+"'\">"+
        "                            <i class=\"layui-icon\">&#xe640;</i>"+
        "                        </button>"+
        "                    </div>"+
        "                </div>"+
        "             </div>";

    $('#exactbar_contend').append(html_bar);

    Search_rownum++;
    layui.use('form', function() {
        var form = layui.form; //只有执行了这一步，部分表单元素才会自动修饰成功
        form.render();
    });
}


function Search_exactSearch() {
    //loading
    // ShowLoading("show");
    // Search_CleanTbale();
    //获取数据存入数组
    var GetDataFunc = function () {
        var data = new Array();
        var row=0,column=0;
        $("#exactbar_contend").children().each(function () {
            data[row] = new Array();
            column=0;
            $(this).each(function () {
                if ($(this).find("select[name='Search_sel_Conjunction']").val() != null){
                    data[row][column++]=$(this).find("select[name='Search_sel_Conjunction']").val();
                }
                data[row][column++]=$(this).find("select[name='Search_sel_Fields']").val();
                data[row][column++]=$(this).find("input[name='title']").val();
            });
            row++;
        });
        return data;
    }
    //根据数据拼写sql
    var ConvertData = function (data) {
        var bIsExact = false;
        var sql;
        if (data[0][1] == "" ||  data[0][1] == null)       return;
        if (bIsExact){//字段精确查询
            sql = "select * from cancerdb where " + data[0][0]+"="+"'"+data[0][1]+"'";
            for(var i in data) {
                if(i>0){
                    sql+=" "+data[i][0]+" "+data[i][1]+"="+"'"+data[i][2]+"'";
                }
            }
        }else{//字段模糊查询
            sql = "select * from cancerdb where " + '`'+data[0][0]+'`'+" like "+"'%"+data[0][1]+"%'";
            for(var i in data) {
                if(i>0){
                    if (data[i][0] == "NOT"){
                        sql+=" AND "+'`'+data[i][1]+'`' +" NOT like "+"'%"+data[i][2]+"%'";
                    }else{
                        sql+=" "+data[i][0]+" "+'`'+data[i][1]+'`' +" like "+"'%"+data[i][2]+"%'";
                    }
                }
            }
        }
        return sql;
    }
    var data = GetDataFunc();
    var sql = ConvertData(data);


    if(!(sql == "" || sql == null || sql == undefined)) {
        //设置cookie
        var JsonParam = {
            type: "exact",
            key: sql,
            data:data
        };
        var strParam = JSON.stringify(JsonParam);
        $.cookie('param',strParam);
        //跳转
        window.location.href="/bic/html/search_data.do";
    }
}

function Search_reset() {
    //删除新增的行
    $("#exactbar_contend").children().each(function () {
        var strID = $(this).attr('id');
        if (strID != null){
            var id = strID.match(/\d+/);
            del(id);
        }
    });
    //重置原有表单
    $("#exactbar_contend").children().each(function () {
        $(this).each(function () {
            $(this).find("select[name='Search_sel_Fields']").val("Cancer");
            $(this).find("input[name='title']").val("");
        });
    });
    $("#Search_input_fuzzy").val("");
    //刷新
    layui.use('form', function() {
        var form = layui.form;
        form.render();
    });
}
//input绑定/解除 autocomplete
function Search_bind_autocomplete(node,isbind) {
    if (isbind){
        var selsource = [
                "HLA-A*26:01",
                "HLA-B*40:02",
                "HLA-C*03:04",
                "NA",
                "mICAM-1",
                "HLA-A29:01",
                "HLA-DPA1*01:03/DPB1*04:01",
                "HLA-DPA1*01:03/DPB1*04:02"
            ];
        node.autocomplete({
            minLength: 0,
            source: selsource,
            disabled:false,
            focus :function () {
                return false;
            },
            select: function(event, ui){
                $this = $(this);
                setTimeout(function () {
                    $this.blur();
                }, 1);
            }
        }).focus(function(){
                $(this).autocomplete("search");
                return false;
            }
        );

    }else {
        node.autocomplete({
            disabled:true
        });
    }
}
