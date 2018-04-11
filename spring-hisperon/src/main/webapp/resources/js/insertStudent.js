var $URL;
$(document).ready(function () {
    //addEvent
    var $idButtonListStudent = $('#idButtonListStudent');
    if ($idButtonListStudent.length)
        $idButtonListStudent.click(listStudent);

    $URL = $('#inp_url_home').val();
});


function listStudent() {
    $.ajax({
        type: 'GET',
        url: $URL + "student/json",
        dataType: 'json',
        success: function (data) {
            console.debug(data);
            fillTable(data)
        },
        error: function (jqXHR, status, error) {
            console.debug(error);
        },
        complete: function (jqXHR, status) {
            console.debug(status);
        }
    });

}

function fillTable(data) {
    var $table = $('#idTableStudentAjax');

    var $trHeader = $('<tr />');
    $trHeader.append($('<th />', {text: 'Nombres'}));
    $trHeader.append($('<th />', {text: 'Apellidos'}));
    $trHeader.append($('<th />', {text: 'Sexo'}));
    $trHeader.append($('<th />', {text: 'Intereses'}));

    $table.append($trHeader);

    for (var i = 0; i < data.length; i++) {
        var $tr = $('<tr />');
        var $tdName = $('<td />', {text: data[i].name});
        var $tdSurname = $('<td />', {text: data[i].surname});
        var $tdSexo = $('<td />', {text: data[i].sex});
        var $tdInterest = $('<td />', {text: data[i].interestString});

        $tr.append($tdName);
        $tr.append($tdSurname);
        $tr.append($tdSexo);
        $tr.append($tdInterest);

        $table.append($tr);
    }

}