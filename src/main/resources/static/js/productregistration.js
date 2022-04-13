function CTlist(componentcategoryNo) {
    $.ajax({
        url: "/admin/CTlist",
        data: {"componentcategoryNo" : componentcategoryNo }

    }).done(function(fragment) {
    $("#componentlist").replaceWith(fragment);
    });
}

function CTpick (componentNo, componentcategoryNo) {
    $.ajax({
        url: "/admin/CTpick",
        data: {"componentNo" : componentNo, "componentcategoryNo" : componentcategoryNo},
        method: "post"
    }).done(function(fragment) {
    $("#data"+componentcategoryNo).replaceWith(fragment);
    });
}