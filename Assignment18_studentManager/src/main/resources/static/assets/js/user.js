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


