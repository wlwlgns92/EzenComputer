function CTlist(componentcategoryNo) {
    $.ajax({
        url: "/admin/CTlist",
        data: {"componentcategoryNo" : componentcategoryNo }

    }).done(function(fragment) {
    $("#componentlist").replaceWith(fragment);
    });
}

function CTpick (componentNo) {

    $.ajax({
        url: "/admin/CTpick",
        data: {"componentNo" : componentNo},
        method: "post"
    });
}