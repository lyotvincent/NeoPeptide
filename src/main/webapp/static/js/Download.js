function Download_click() {
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
        },
        error: function (XMLHttpRequest, textStatus, errorThrown) {

        }
    });

    var AddDownload = function (country_id) {
        $.ajax({
            url: "/Country/UpdateDownload.do",
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
}