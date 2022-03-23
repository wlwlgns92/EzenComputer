function CTlist(componentcategoryNo) {
    $.ajax({
        url: "/admin/CTlist",
        data: {"componentcategoryNo" : componentcategoryNo },
        success: function(result) {

        }
    });
}