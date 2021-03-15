const board = {
    save: function () {
        const data = {
            title: document.querySelector('#title').value,
            author: document.querySelector('#author').value,
            content: document.querySelector('#content').value
        }

        fetch("/api/v1/board", {
            method: 'POST', // or 'PUT'
            body: JSON.stringify(data), // data can be `string` or {object}!
            headers: {
                'Content-Type': 'application/json'
            }
        }).then((response) => {
            if(response.status == 200){
                location.href='/'
            }else{
                alert('권한이 없습니다. 가입을 해주세요.')
            }
        })
          .catch(error => alert(error))

    },
    update : function () {
        const data = {
            title: document.querySelector('#title').value,
            content: document.querySelector('#content').value
        }

        const id = document.querySelector('#id').value

        fetch("/api/v1/board/"+id, {
            method: 'PUT', // or 'PUT'
            body: JSON.stringify(data), // data can be `string` or {object}!
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(res => res.json())
            .then(response => location.href='/board/boardDetail/'+id)
            .catch(error => console.error('Error:', error));
    },
    delete : function () {

        const id = document.querySelector('#id').value

        fetch("/api/v1/board/"+id, {
            method: 'DELETE', // or 'PUT'
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(res => res.json())
            .then(response => location.href='/')
            .catch(error => console.error('Error:', error));

    }
};