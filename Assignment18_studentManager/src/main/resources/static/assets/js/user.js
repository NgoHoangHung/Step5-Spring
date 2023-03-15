//hàm tạo user
const createUser = async (user) => {
    const response = await fetch('http://localhost:8080/users/new', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(user)
    });

    const data = await response.json();
    console.log(data);
};


const submitForm = () => {
    const user = {
        name: document.getElementById('name').value,
        phone: document.getElementById('phone').value,
        email: document.getElementById('email').value,
        password: document.getElementById('password').value
    };

    createUser(user);
};

//hàm tạo user
const createUser = async (user) => {
    const response = await fetch('http://localhost:8080/users/new', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(user)
    });

    const data = await response.json();
    console.log(data);
};


//xóa User
function deleteUser(id) {
    fetch("http://localhost:8080/delete/" + id, {
        method: 'DELETE',
        headers: {
            'Content-Type': 'application/json'
        }
    })
        .then(response => response.json())
        .then(() => {
            alert('xoá thành công')
            window.location.reload();
        })
        .catch(error =>{
            console.error(error.toString());
        });
}