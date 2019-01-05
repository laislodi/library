$(document).ready(function () {
    clientPageInit();
    $("#btn-search-client").on("click", function() {

        searchClient();
    });
});

function clientPageInit() {
    $.get("http://localhost:8080/api/client/find", function (data) {
        console.log("Entrou em clientPageInit()");
        clearTable();
        fillTable(data);
    });
}

function clearTable() {
    console.log("Entrou em clearTable()");
    $("tbody tr").remove();
}

function fillTable(data) {
    console.log("Entrou em fillTable()");
    for (var i = 0; i < data.length; i++) {
        var name = data[i].name;
        var cpf = data[i].cpf;
        var telephone = data[i].telephone;
        var email = data[i].email;

        var tableBody = $("#client-table").find("tbody");
        var newLine = enterNewLine(name, cpf, telephone, email);
        tableBody.append(newLine);
    }
}

function enterNewLine(name, cpf, telephone, email) {
    console.log("Entrou em enterNewLine()");
    var line = $("<tr>");
    var nameColumn = $("<td>").text(name);
    var cpfColumn = $("<td>").text(cpf);
    var telephoneColumn = $("<td>").text(telephone);
    var emailColumn = $("<td>").text(email);

    line.append(nameColumn);
    line.append(cpfColumn);
    line.append(telephoneColumn);
    line.append(emailColumn);

    return line;
}
