function CToutput(componentcategoryNo) {
    $.ajax({
        url: "/component/CToutput",
        data: { "componentcategoryNo": componentcategoryNo }
    }).done(function(fragment) {
        $("#listbox").replaceWith(fragment);
    });
}