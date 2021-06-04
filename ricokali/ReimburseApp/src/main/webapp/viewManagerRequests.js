/** to return multiple records */
function viewManagerRequests() {
    let xhr = new XMLHttpRequest();
    const id = document.getElementById("manager_id").value;
    let url = "/ReimburseApp/api2/manReview?manager_id=" + id;

    xhr.onreadystatechange = function () {
        if (this.readyState === 4 && this.status == 200) {
            const man = JSON.parse(this.responseText);
            console.log(man);
            let tbody = document.getElementById('infoHere');
            for (let r of man) {
                let tr = document.createElement('tr');

                let manager_request_id = document.createElement('td');
                let description = document.createElement('td');
                let approved = document.createElement('td');
                let denied = document.createElement('td');
                let file = document.createElement('td');
                let manager_id = document.createElement('td');
                let link = document.createElement('td');
                let manager_supervisor_id = document.createElement('td');


                manager_request_id.innerText = r.manager_request_id;
                description.innerText = r.description;
                approved.innerText = r.approved;
                denied.innerText = r.denied;
                file.innerText = r.file;
                manager_id.innerText = r.manager_id;
                link.innerText = r.link;
                manager_supervisor_id = r.manager_supervisor_id;

                tr.append(manager_request_id);
                tr.append(description);
                tr.append(approved);
                tr.append(denied);
                tr.append(file);
                tr.append(manager_id);
                tr.append(link);
                tr.append(manager_supervisor_id);


                tbody.append(tr);
            }
        }
    }
    xhr.open('GET', url);
    xhr.send();
}