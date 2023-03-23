const register = document.getElementById("register-form")
const username = document.getElementById("username")
const password = document.getElementById("password")
const email = document.getElementById("email")

console.log("hoihi");

register.addEventListener("submit", function (e) {
    e.preventDefault();

    const usernameValue = username.value;
    const passwordValue = password.value;
    const emailValue = email.value;
    console.log(usernameValue);
    console.log(passwordValue);
    console.log(emailValue);

    fetch("http://localhost:8080/api/auth/signup",
        {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                username: usernameValue,
                password: passwordValue,
                email: emailValue
            })
        }).then((data) => {
        return data.json()

    }).then((data) => alert(data.message))
        .catch(error => console.log(error))
})