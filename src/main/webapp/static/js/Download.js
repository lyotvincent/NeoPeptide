function Download_click() {
    var AddDownload = function (country_id) {
        $.ajax({
            url: "/bic/Country/UpdateDownload.do",
            type: "POST",
            data:   {
                "country_id":country_id
            },
            success: function(){
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
            }
        });
    }
    //有cookie，说明访问过，不需要添加
    var ViewsPosCookie= $.cookie('ViewsPos');
    if (ViewsPosCookie != null && ViewsPosCookie != undefined) {
        AddDownload(ViewsPosCookie.country_id);
    } else {//没有的话，需要请求，然后加入cookie
        //根据ip获取国家，加入访问者数据中
        var ip = returnCitySN.cip;
        $.ajax( {
            url: "http://api.map.baidu.com/location/ip",
            type: "GET",
            dataType: 'jsonp',
            data:   {
                "ak":"F454f8a5efe5e577997931cc01de3974",
                "ip": ip
            },
            success: function(data){
                var str = data.address;
                var country_id = str.slice(0,2);
                AddDownload(country_id);
                //设置cookie
                var JsonParam = {
                    ip: ip,
                    country_id: country_id
                };
                var ViewsPos = JSON.stringify(JsonParam);
                $.cookie('ViewsPos',ViewsPos,{ expires: 1 });
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {

            }
        });
    }


}