function updatingUser(){
    $("#updateProfile").submit(function(event){
        event.preventDefault(); //prevent default action
        var request_method = $(this).attr("method"); //get form GET/POST method
        $.ajax({
            url :  "/api/checkEmailUser",
            type: request_method,
            dataType: 'json',
            contentType: 'application/json',
            data: JSON.stringify(registerRequest),
            success: function(data) {
                if(data.id==""||data.id==null){
                 $.ajax({
                        url :  "/api/createNewAccount",
                        type: request_method,
                        dataType: 'json',
                        contentType: 'application/json',
                        data: JSON.stringify(registerRequest),
                        success: function(data) {
                            window.location.href = 'http://localhost:8080/login';
                            alert("Register Done!");
                        },
                        error: function(data) {
                        },
                    });
                }
                else{
                    alert("Email telah terdaftar");
                }
            },
            error: function(data) {
            },
        });
    });
}
$(document).ready( function () {
    updatingUser();
})