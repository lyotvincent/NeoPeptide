jQuery(document).ready(function ($) {
    
    //Set the carousel options
    $('#quote-carousel').carousel({
        pause: true,
        interval: 4000,
    });
    // fancybox
    $(".fancybox").fancybox();
    //isotope
    if ($('.isotopeWrapper').length) {
        var $container = $('.isotopeWrapper');
        var $resize = $('.isotopeWrapper').attr('id');
        // initialize isotope
        $container.isotope({
            itemSelector: '.isotopeItem',
            resizable: false, // disable normal resizing
            masonry: {
                columnWidth: $container.width() / $resize
            }
        });
        $("a[href='#top']").click(function () {
            $("html, body").animate({
                scrollTop: 0
            }, "slow");
            return false;
        });
        $('.navbar-inverse').on('click', 'li a', function () {
            $('.navbar-inverse .in').addClass('collapse').removeClass('in').css('height', '1px');
        });
        $('#filter a').click(function () {
            $('#filter a').removeClass('current');
            $(this).addClass('current');
            var selector = $(this).attr('data-filter');
            $container.isotope({
                filter: selector,
                animationOptions: {
                    duration: 1000,
                    easing: 'easeOutQuart',
                    queue: false
                }
            });
            return false;
        });
        $(window).smartresize(function () {
            $container.isotope({
                // update columnWidth to a percentage of container width
                masonry: {
                    columnWidth: $container.width() / $resize
                }
            });
        });
    }
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
            AddVisitor(country_id);
        },
        error: function (XMLHttpRequest, textStatus, errorThrown) {

        }
    });

    var AddVisitor = function (country_id) {
        $.ajax({
            url: "/bic/Country/UpdateVisit.do",
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
});

