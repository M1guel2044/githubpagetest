document.addEventListener("DOMContentLoaded", function () {
    const commentForm = document.getElementById("commentForm");
    const usernameInput = document.getElementById("usernameInput");
    const commentInput = document.getElementById("commentInput");
    const commentsSection = document.getElementById("commentsSection");

    // Cargar comentarios almacenados
    function loadComments() {
        commentsSection.innerHTML = "";
        let comments = JSON.parse(localStorage.getItem("comments")) || [];
        comments.forEach(comment => {
            displayComment(comment.name, comment.text);
        });
    }

    // Agregar comentario al DOM
    function displayComment(name, text) {
        const commentDiv = document.createElement("div");
        commentDiv.classList.add("comment");
        commentDiv.innerHTML = `<strong>${name}:</strong> ${text}`;
        commentsSection.appendChild(commentDiv);
    }

    // Manejar el envío del comentario
    commentForm.addEventListener("submit", function (event) {
        event.preventDefault();
        const username = usernameInput.value.trim();
        const commentText = commentInput.value.trim();

        if (username !== "" && commentText !== "") {
            let comments = JSON.parse(localStorage.getItem("comments")) || [];
            comments.push({ name: username, text: commentText });
            localStorage.setItem("comments", JSON.stringify(comments));
            displayComment(username, commentText);
            usernameInput.value = "";
            commentInput.value = "";
        }
    });

    // Cargar comentarios al iniciar
    loadComments();
});
