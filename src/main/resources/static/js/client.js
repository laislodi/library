
function searchClient() {
    var selectInput = $("#select-document").val();
    var valueOf = $("#value-of").val();
    console.log("searchClient : " + selectInput);
    console.log("valueof : " + valueOf);
    if (valueOf === '') {
        bringAll();
    } else
        if ( selectInput === 'document') {
            searchByCpf(valueOf)
    } else {
            searchByName(valueOf)
    }
}

function bringAll() {
    $.get("http://localhost:8080/api/client/find", function (data) {
        clearTable();
        fillTable(data)
    });
}

function searchByCpf(cpf) {

    if (cpf === "") {
        cpf = "*";
    }
    $.get("http://localhost:8080/api/client/find-document/" + cpf, function (data) {
        console.log(data);
        clearTable();
        fillTable(data)
    });
}

function searchByName(name) {

    if (name === "") {
        name = "*";
    }
    $.get("http://localhost:8080/api/client/find-name/" + name, function (data) {
        clearTable();
        fillTable(data)
    });
}


