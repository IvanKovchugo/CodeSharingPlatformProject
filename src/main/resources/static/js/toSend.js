// function send() {
//     let object = {
//         "code": document.getElementById("code_snippet").value,
//         "time": document.getElementById("time_restriction").value,
//         "views": document.getElementById("views_restriction").value
//     };
//
//     let json = JSON.stringify(object);
//
//     let xhr = new XMLHttpRequest();
//     xhr.open("POST", "/api/code/new", false)
//     xhr.setRequestHeader('Content-type', 'application/json');
//     xhr.send(json);
//
//     if (xhr.status === 200) {
//         alert("Success!" );
//     }
// }

function send() {
    let object = {
        "code": document.getElementById("code_snippet").value,
        "time": document.getElementById("time_restriction").value,
        "views": document.getElementById("views_restriction").value
    };

    let json = JSON.stringify(object);

    let xhr = new XMLHttpRequest();
    xhr.open("POST", "/api/code/new", false)
    xhr.setRequestHeader('Content-type', 'application/json');
    xhr.onreadystatechange = function() {
        if (xhr.readyState === 4 && xhr.status === 200) {
            let response = JSON.parse(xhr.responseText);
            let uuid = response.uuid;
            alert("You can find your code by UUID: " + uuid);
        }
    };
    xhr.send(json);
}

