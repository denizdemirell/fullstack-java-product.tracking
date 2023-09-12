// Get the query string from the URL
const queryString = window.location.search;

// Create a URLSearchParams object from the query string
const urlParams = new URLSearchParams(queryString);

// Get the value of the 'id' parameter
const itemId = urlParams.get('id');

console.log(itemId); // Output the item ID for testing

var xhttp = new XMLHttpRequest();
xhttp.onreadystatechange = function() {
    if (this.readyState == 4 && this.status == 200) {
    // Typical action to be performed when the document is ready:
        var response = xhttp.responseText;
        console.log("ok"+response);
        const obj = JSON.parse(response);

        const id = document.getElementById('id');
        id.value = obj.id;
        const urun_adi = document.getElementById('urun_adi');
        urun_adi.value = obj.urun_adi;
        const urun_kodu = document.getElementById('urun_kodu');
        urun_kodu.value = obj.urunkod;
        const fiyat = document.getElementById('fiyat');
        fiyat.value = obj.fiyat;
        const hammadde = document.getElementById('hammadde');
        hammadde.value = obj.hammadde;
        const kusurlu_mu = document.getElementById('kusurlu_mu');
        kusurlu_mu.value = obj.kusurlu_mu;
        

        fabrikaBilgileriniDoldur(obj);

    }
};
xhttp.open("GET", "http://127.0.0.1:8080/api/urun/getUrun/"+itemId, true);
xhttp.send();




function fabrikaBilgileriniDoldur(obj) {
    var xhttp2 = new XMLHttpRequest();
    xhttp2.onreadystatechange = function() {
    if (this.readyState == 4 && this.status == 200) {
    // Typical action to be performed when the document is ready:
        var response2 = xhttp2.responseText;
        console.log("ok"+response2);
        const obj2 = JSON.parse(response2);
        
        const dropdown = document.getElementById('myDropdown');
        obj2.forEach((item) => {
            // Create a new option element
            const option = document.createElement('option');
            // Set the value and text of the option
            option.value = item.fabrikaId;
            option.text = item.fabrikaAdi;
            // Append the option to the dropdown
            dropdown.appendChild(option);
        });
        const fabrika = document.getElementById('myDropdown');
        fabrika.value = obj.fabrika.fabrikaId;
    }
    };
    xhttp2.open("GET", "http://127.0.0.1:8080/api/fabrikalar/getAll", true);
    xhttp2.send();
}

function putService() {
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
         if (this.readyState == 4 && this.status == 200) {
             alert(this.responseText);
         }
    };
    var kayit = {
        "id": document.getElementById('id').value,
        "urun_adi": document.getElementById('urun_adi').value,
        "urunkod": document.getElementById('urun_kodu').value,
        "fiyat": document.getElementById('fiyat').value,
        "hammadde": document.getElementById('hammadde').value,
        "kusurlu_mu": document.getElementById('kusurlu_mu').value,
        "fabrika" : { "fabrikaId" : document.getElementById('myDropdown').value}
    };
    xhttp.open("PUT", "http://127.0.0.1:8080/api/urun/urunGuncelle", true);
    xhttp.setRequestHeader("Content-type", "application/json");
    xhttp.send(JSON.stringify(kayit));
}