var $window = $(window);

function check_if_in_view() {
    var window_height = $window.height();
    var window_top_position = $window.scrollTop();
    var window_bottom_position = window_top_position + window_height;

    $.each($(".explain"), function () {
        var $element = $(this);
        var element_height = $element.outerHeight();
        var element_top_position = $element.offset().top;
        var element_bottom_position = element_top_position + element_height;

        //check to see if this current container is within viewport
        if (element_top_position < window_bottom_position - 250) {
            if ($element.hasClass("slideOutLeft")) {
                $($element.removeClass("slideOutLeft"));
            }
            if ($(".explain-second").hasClass("fadeOutExplain")) {
                $($(".explain-second").removeClass("fadeOutExplain"));
            }
            $element.addClass("slideInLeft");
            $(".explain-second").addClass("fadeInExplain");
        } else {
            if ($element.hasClass("slideInLeft")) {
                $($element.removeClass("slideInLeft"));
            }
            if ($(".explain-second").hasClass("fadeInExplain")) {
                $($(".explain-second").removeClass("fadeInExplain"));
            }
            $element.addClass("slideOutLeft");
            $(".explain-second").addClass("fadeOutExplain");
        }
    });
}

$window.on("scroll resize", check_if_in_view);
$window.trigger("scroll");