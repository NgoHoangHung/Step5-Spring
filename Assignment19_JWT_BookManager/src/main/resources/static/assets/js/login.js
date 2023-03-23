const login = document.getElementById("login-form")
const username = document.getElementById("username")
const password = document.getElementById("password")
login.addEventListener("submit", function (e) {
    e.preventDefault();
    const usernameValue = username.value
    const passwordValue = password.value
    console.log(usernameValue)
    console.log(passwordValue)

    fetch("/api/auth/login",
        {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                username: usernameValue,
                password: passwordValue
            })
        }).then((data) => {
        return data.json()
    }).then((data) => {
        // localStorage.setItem("auth",JSON.stringify(data)); lấy toàn bộ thông tin
        localStorage.setItem("auth", data.accessToken);
        alert("đăng nhập thành công")
        window.location.href = '/home'

    })
        .catch(error => console.log(error))
})