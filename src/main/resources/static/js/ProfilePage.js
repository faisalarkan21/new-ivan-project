function updateProfile(){
    $("#updateProfile").submit(function(event){
        event.preventDefault(); //prevent default action
        var request_method = $(this).attr("method"); //get form GET/POST method
        var dataUser={
            firstName:$('#changeFirstName').val(),
            lastName:$('#changeLastName').val(),
            mobileNumber:$('#changePhoneNumber').val()
        };
        $.ajax({
            url :  "/api/updateProfile",
            type: request_method,
            dataType: 'json',
            contentType: 'application/json',
            data: JSON.stringify(dataUser),
            success: function(data) {
                $('#profileName').text(data.firstName+" "+data.lastName);
                $('#firstName').text(data.firstName);
                $('#changeFirstName').val(data.firstName);
                $('#changeLastName').val(data.lastName);
                $('#changePhoneNumber').val(data.mobileNumber);
            },
            error: function(data) {
            },
        });
    });
}
function updateUser(){
    $("#updateUser").submit(function(event){
        event.preventDefault(); //prevent default action
        var request_method = $(this).attr("method"); //get form GET/POST method
        var dataUser={
            email:$('#changeEmail').val(),
            password:$('#changePassword').val()
        };
        $.ajax({
            url :  "/api/updateProfile",
            type: request_method,
            dataType: 'json',
            contentType: 'application/json',
            data: JSON.stringify(dataUser),
            success: function(data) {
                $('#changeEmail').text(data.email);
            },
            error: function(data) {
            },
        });
    });
}
$(document).ready( function () {
    updateProfile();
    updateUser();
})