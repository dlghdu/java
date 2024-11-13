
$(document).ready(() => {

    $('#signin').click(() => {

        let userId = $('#user_id').val();
        let password = $('#password').val();

        let formData = {
            username : userId,
            password : password
        }


        $.ajax({
            type: 'POST',
            url: '/login', // 서버의 엔드포인트 URL
            data: JSON.stringify(formData),
            contentType: 'application/json; charset=utf-8',
            dataType: 'json', // 서버에서 받을 데이터의 타입
            success: (response) => {
                console.log('res :: ', response)
                if (response.loggedIn) {
                    // 성공 후 다른 페이지로 이동하거나 처리할 코드 작성 가능
                    window.location.href = response.url;
                }
                alert(response.message);
            },
            error: (error) => {
                // 실패 시 실행될 콜백 함수
                console.error('오류 발생:', error);
                alert(error.responseJSON.message);
                window.location.href = error.responseJSON.url;
            }
        });

    });

});