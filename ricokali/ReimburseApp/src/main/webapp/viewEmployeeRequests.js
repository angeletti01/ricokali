/** to return multiple records */
function viewEmployeeRequests() {
    let xhr = new XMLHttpRequest();
    const id = document.getElementById("employee_id").value;
    let url = "/ReimburseApp/api/emplReview?employee_id=" + id;

    xhr.onreadystatechange = function () {
        if (this.readyState === 4 && this.status == 200) {
            const empl = JSON.parse(this.responseText);
            console.log(empl);
            let tbody = document.getElementById('infoHere');
            for (let r of empl) {
                let tr = document.createElement('tr');

                let employee_request_id = document.createElement('td');
                let description = document.createElement('td');
                let approved = document.createElement('td');
                let denied = document.createElement('td');
                let file = document.createElement('td');
                let link = document.createElement('td');
                let employee_id = document.createElement('td');

                employee_request_id.innerText = r.employee_request_id;
                description.innerText = r.description;
                approved.innerText = r.approved;
                denied.innerText = r.denied;
                file.innerText = r.file;
                link.innerText = r.link;
                employee_id.innerText = r.employee_id;

                tr.append(employee_request_id);
                tr.append(description);
                tr.append(approved);
                tr.append(denied);
                tr.append(file);
                tr.append(link);
                tr.append(employee_id);

                tbody.append(tr);
            }

        }

    }
    xhr.open('GET', url);
    xhr.send();
}

/*For returning only one record*/
/*function viewEmployeeInformation()
{
    let xhr = new XMLHttpRequest();
    const id = document.getElementById("employee_id").value;
    let url = "/ReimburseApp/api/emplReview?employee_id=" + id; //?employee_id, id is only for when you need a parameter for the function

    xhr.onreadystatechange = function()
    {
        if(this.readyState === 4 && this.status == 200)
        {
            const empl = JSON.parse(this.responseText);
            console.log(empl);
            let tbody = document.getElementById('infoHere');


                let tr = document.createElement('tr');

                let employee_request_id = document.createElement('td');
                let description = document.createElement('td');
                let approved = document.createElement('td');
                let denied = document.createElement('td');
                let file = document.createElement('td');
                let link = document.createElement('td');
                let employee_id = document.createElement('td');

                employee_request_id.innerText = empl.employee_request_id;
                description.innerText = empl.description;
                approved.innerText = empl.approved;
                denied.innerText = empl.denied;
                file.innerText = empl.file;
                link.innerText = empl.link;
                employee_id.innerText = empl.employee_id;

                tr.append(employee_request_id);
                tr.append(employee_id);
                tr.append(description);
                tr.append(description);
                tr.append(approved);
                tr.append(denied);
                tr.append(file);
                tr.append(link);

                tbody.append(tr);


        }

    }
          xhr.open('GET', url);
        xhr.send();
} */


/*	window.onload = () =>
{
    viewEmployeeRequests();
} */