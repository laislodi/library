$(document).ready(function () {
    $("#btn-save").on("click", function () {
        console.log("Entrou em document.ready");
        saveClient();
        resetForm();
    });
});

function resetForm() {
    console.log("Entrou em resetForm()");
    $("#input-client-name").val("");
    $("#input-client-cpf").val("");
    $("#input-client-ddd").val("");
    $("#input-client-telephone").val("");
    $("#input-client-email").val("");
}

function saveClient() {
    console.log("Entrou em saveClient()");
    var name = $("#input-client-name").val();
    var cpf = $("#input-client-cpf").val();
    var ddd = $("#input-client-ddd").val();
    var telephone = $("#input-client-telephone").val();
    var email = $("#input-client-email").val();


    newClient(name, cpf, ddd, telephone, email);
}

function newClient(name, cpf, ddd, telephone, email) {
    console.log("Entrou em newClient()");

    var client = {
        "name" : name,
        "cpf" : cpf,
        "email" : email,
        "telephone" : ddd+telephone,
        "loanList" : []
    };

    $.ajax({
        'type': 'POST',
        'url': "http://localhost:8080/api/client/new",
        'contentType': 'application/json',
        'data': JSON.stringify(client)
    }).done(function (response) {
            console.log("idClient: ");
            console.log(response.id);
            console.log("response: ");
            console.log(response);
    });
}
