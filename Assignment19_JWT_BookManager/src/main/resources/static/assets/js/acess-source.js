
fetch("/api/test/user", {
    method: 'GET',
    headers: {
        'Content-Type': 'application/json',
        'Authorization': `Bearer ${localStorage.getItem("auth")}`
    }
}).then((data) => {
    console.log(data)
})