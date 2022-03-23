function CTlist(componentcategoryNo) {
    $.ajax({
        url: "/admin/CTlist",
        data: {"componentcategoryNo" : componentcategoryNo }

    }).done(function(fragment) {
    $("#componentlist").replaceWith(fragment);
    });
}