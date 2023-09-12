console.log("test 1");

function postService() {
    window.location.href ='create/create.html';
}


    function getServiceForTable() {

        

    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
            

            var response = xhttp.responseText;
            console.log("ok"+response);
            const obj  = JSON.parse(response);

            const urunList = document.getElementById('urunList');
            urunList.innerHTML = '';

            obj.forEach((item) => {
                const row = document.createElement('tr');
                const idCell = document.createElement('td');
                const urunAdCell = document.createElement('td');
                const urunKodCell = document.createElement('td');
                const fiyatCell = document.createElement('td');
                const hammaddeCell = document.createElement('td');
                const kusurCell = document.createElement('td');
                const ulkeCell = document.createElement('td');
                const fabrikaAdCell = document.createElement('td');
                const actionCell = document.createElement('td');
                const deleteCell = document.createElement('td');
                

                idCell.textContent = item.id;
                urunAdCell.textContent = item.urun_adi;
                urunKodCell.textContent = item.urunkod;
                fiyatCell.textContent = item.fiyat;
                hammaddeCell.textContent = item.hammadde;
                kusurCell.textContent = item.kusurlu_mu;
                if (item.fabrika) {
                    ulkeCell.textContent = item.fabrika.ulke;
                    fabrikaAdCell.textContent = item.fabrika.fabrikaAdi;
                } else {
                    ulkeCell.textContent = "Bilgi yok"; 
                    fabrikaAdCell.textContent = "Bilgi yok"; 
                }
                
                const updateButton = document.createElement('button');
                updateButton.textContent = 'Update';
                updateButton.addEventListener('click', function() {
                    
                    navigateToUpdateScreen(item.id); 
                });

                actionCell.appendChild(updateButton);

                const deleteButton = document.createElement('button');
                deleteButton.textContent = 'Delete';
                deleteButton.addEventListener('click', function() {
                    deleteBolum(item.id);
                });

                deleteCell.appendChild(deleteButton);
                


                row.appendChild(idCell);
                row.appendChild(urunAdCell);
                row.appendChild(urunKodCell);
                row.appendChild(fiyatCell);
                row.appendChild(hammaddeCell);
                row.appendChild(kusurCell);
                row.appendChild(ulkeCell);
                row.appendChild(fabrikaAdCell);
                row.appendChild(actionCell);
                row.appendChild(deleteCell);
                
                
                

                urunList.appendChild(row);
            });
        }
    };
    var ad = document.getElementById('ad').value;
    if(ad===null || ad===undefined || ad==="") {
        xhttp.open("GET", "http://127.0.0.1:8080/api/urun/getAll", true);
    } else {
        xhttp.open("GET", "http://127.0.0.1:8080/api/urun/ara/"+ad, true);
    }

    xhttp.send();  
}
     


function navigateToUpdateScreen(itemId) {
    window.location.href = '/update/update.html?id=' + itemId;
    
  }

  
function deleteBolum(id) {
    
    var confirmDelete = confirm("Silmek istediğinize emin misiniz?");
    
    if (confirmDelete) {
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
         if (this.readyState == 4 && this.status == 200) {
             alert(this.responseText);
             getServiceForTable();
         }
    };
    xhttp.open("DELETE", "http://127.0.0.1:8080/api/urun/delete/"+id, true);
    xhttp.send();
}
}


