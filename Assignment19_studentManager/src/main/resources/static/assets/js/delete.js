// function deleteUser(id) {
//     fetch("http://localhost:8080/users/delete/"+id,{
//         method: 'DELETE',
//         headers: { 'Content-Type': 'application/json'
//         }
//     })
//         .then(response => response.json())
//         .then(() => {
//             alert('xóa rồi nhé anh em');
//             window.location.reload();
//         })
//         .catch(error => {
//             console.error(error.toString());
//         });
// }
//xóa User
function deleteUser(id) {
    fetch("http://localhost:8080/users/delete/" + id, {
        method: 'DELETE',
        headers: {
            'Content-Type': 'application/json'
        }
    })
        .then(() => {
            alert('xoá thành công')
            window.location.reload();
        })
        .catch(error => {
            console.error(error.toString());
        });
}