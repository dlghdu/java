
$(document).ready(() => {
    checkToken();
    setupAjax();
    getUserInfo().then((userInfo) => {
        $('#hiddenUserId').val(userInfo.userId);
        $('#hiddenUserName').val(userInfo.userName);
        loadBoardDetail();
    }).catch((error) => {
        console.log('Error while fetching user info : ', error);
    })
});

let editArticle = () => {
    let resourceId = $('#hiddenId').val();
    window.location.href = "/update/" + resourceId;
}

let deleteArticle = () => {

    let resourceId = $('#hiddenId').val();
    let filePath = $('#hiddenFilePath').val();

    $.ajax({
        type: 'DELETE',
        url: '/api/board/' + resourceId, // 실제 서버 API URL 및 삭제할 리소스 ID
        data: JSON.stringify({ filePath: filePath }), // filePath를 JSON으로 서버에 전송
        contentType: 'application/json', // JSON 형식으로 전송
        success: (response) => {
            alert('리소스가 성공적으로 삭제되었습니다.');
            window.location.href = '/'; // 성공 후 목록 페이지로 이동
        },
        error: (error) => {
            alert('리소스 삭제 중 오류가 발생했습니다.');
            console.error('Error:', error);
        }
    });
}

let loadBoardDetail = () => {
    let hId = $('#hiddenId').val();
    let hUserId = $('#hiddenUserId').val();
    $.ajax({
        type: 'GET',
        url: '/api/board/' + hId,
        success: (response) => {
            console.log('/api/board/ ', response.userId);
            console.log('/api/board/ ', hUserId);
            console.log('/api/board/ ', hId);
            $('#title').text(response.title);
            $('#content').text(response.content);
            $('#userId').text(response.userId);
            $('#created').text(response.created);


            if (hUserId != response.userId) {
                // 작성자가 본인이 아닐 때
                $('#editBtn').prop('disabled', true);
                $('#deleteBtn').prop('disabled', true);
            } else {
                // 작성자가 본인일 때
                $('#editBtn').prop('disabled', false);
                $('#deleteBtn').prop('disabled', false);
            }

            if (hUserId !== response.userId) {
                // 작성자가 본인이 아닌 경우 리디렉션
                window.location.href = '/access-denied';
            }


            // 파일 목록이 있는 경우 파일 다운로드 링크 추가
            if (response.filePath && response.filePath.length > 0) {
                let filePath = response.filePath;
                $('#hiddenFilePath').val(filePath);
                let fileName = filePath.substring(filePath.lastIndexOf('\\') + 1); // 파일명 추출
                let fileElement = `
                    <li>
                        <a href="/api/board/file/download/${fileName}">${fileName}</a> <!-- 다운로드 링크 -->
                    </li>`;
                $('#fileList').append(fileElement);
            } else {
                $('#fileList').append('<li>첨부된 파일이 없습니다.</li>');
            }
        },
        error: (xhr) => {
            if (xhr.status === 401) {
                alert("로그인이 필요합니다.");
                window.location.href = "/member/login";
            } else if (xhr.status === 403) {
                window.location.href = "/access-denied"; // 권한 부족 시 접근 금지 페이지로 이동
            } else {
                alert("예기치 않은 오류가 발생했습니다.");
            }
        }
    });
};

// JWT 토큰에서 역할 추출하는 함수
function getRoleFromToken() {
    const token = localStorage.getItem('jwt_token');  // 토큰을 로컬 스토리지에서 가져옴
    if (!token) return null;

    const payload = JSON.parse(atob(token.split('.')[1]));  // 토큰에서 페이로드 추출
    return payload.role;  // 역할을 리턴
}