/** to return multiple records */
function listEmployeeRequest() {
    let xhr = new XMLHttpRequest();
    const id = document.getElementById("manager_id").value;
    let url = "/ReimburseApp/api3/listEmployee?manager_id=" + id;

    xhr.onreadystatechange = function () {
        if (this.readyState === 4 && this.status == 200) {
            const empl = JSON.parse(this.responseText);
            console.log(empl);
            let tbody = document.getElementById('infoHere');
            for (let r of empl) {
                let tr = document.createElement('tr');

                let employee_id = document.createElement('td');
                let employeeFirstName = document.createElement('td');
                let employeeLastName = document.createElement('td');
                let username = document.createElement('td');
                let password = document.createElement('td');
                let manager_id = document.createElement('td');
                
                employee_id.innerText = r.employee_id;
                employeeFirstName.innerText = r.employeeFirstname;
                employeeLastName.innerText = r.employeeLastname;
                username.innerText = r.username;
                password.innerText = r.password;
                manager_id.innerText = r.manager_id;
                

                tr.append(employee_id);
                tr.append(employeeFirstName);
                tr.append(employeeLastName);
                tr.append(username);
                tr.append(password);
                tr.append(manager_id);
                

                tbody.append(tr);
            }

        }

    }
    xhr.open('GET', url);
    xhr.send();
}

