$(document).ready(function() {

    $('#signin').click(() => {

        let userId = $('#user_id').val();
        let password = $('#password').val();

        let formData = {
            userId : userId,
            password : password
        }

        $.ajax({
            type: 'POST',
            url: '/login', // 서버의 회원가입 처리 URL
            data: JSON.stringify(formData),
            contentType: 'application/json',
            dataType: 'json', // 서버에서 받을 데이터의 타입
            success: (response) => {
                console.log('res :: ', response)
                if (response.loggedIn) {
                    // 성공 후 다른 페이지로 이동하거나 처리할 코드 작성 가능
                    window.location.href = response.url;
                }
                alert(response.message);
            },
            error: function(error) {
                // 실패 시 실행될 콜백 함수
                console.error('오류 발생:', error);
                alert('로그인 중 오류가 발생했습니다.');
            }
        });
    });
});