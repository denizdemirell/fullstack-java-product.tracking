var xhttp = new XMLHttpRequest();
xhttp.onreadystatechange = function() {
    if (this.readyState == 4 && this.status == 200) {
    
        var response = xhttp.responseText;
        console.log("ok"+response);
        const obj = JSON.parse(response);
        const dropdown = document.getElementById('myDropdown');
        obj.forEach((item) => {
            
            const option = document.createElement('option');
            
            option.value = item.fabrikaId;
            option.text = item.fabrikaAdi;
            
            dropdown.appendChild(option);
        });
    }
};
xhttp.open("GET", "http://127.0.0.1:8080/api/fabrikalar/getAll", true);
xhttp.send();


function postService() {
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
         if (this.readyState == 4 && this.status == 200) {
             alert(this.responseText);
             window.location.href = '../index.html';
         }
    };
    var kayit = {
        "urun_adi": document.getElementById('urun_adi').value,
        "urunkod": document.getElementById('urun_kodu').value,
        "fiyat": parseFloat(document.getElementById('fiyat').value),
        "hammadde": document.getElementById('hammadde').value,
        "kusurlu_mu": document.getElementById('kusurlu_mu').value === "true",
        "fabrika" : { "fabrikaId" : document.getElementById('myDropdown').value}
    };
    xhttp.open("POST", "http://127.0.0.1:8080/api/urun/urunKaydet", true);
    xhttp.setRequestHeader("Content-type", "application/json");
    xhttp.send(JSON.stringify(kayit));
}