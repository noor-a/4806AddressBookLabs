$(document).ready(function(){
    $.ajax({
        url:"http://localhost:8090"
    }).then(function(data){
        $('.buddy-name').append(data.name);
        $('.buddy-address').append(data.address);
        $('.buddy-phoneNumber').append(data.phoneNumber);
    });
});