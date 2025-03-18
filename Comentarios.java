document.addEventListener("DOMContentLoaded", function () {
    const commentForm = document.getElementById("commentForm");
    const commentInput = document.getElementById("commentInput");
    const commentsSection = document.getElementById("commentsSection");

    // Cargar comentarios almacenados
    function loadComments() {
        commentsSection.innerHTML = "";
        let comments = JSON.parse(localStorage.getItem("comments")) || [];
        comments.forEach(comment => {
            displayComment(comment);
        });
    }

    // Agregar comentario al DOM
    function displayComment(text) {
        const commentDiv = document.createElement("div");
        commentDiv.classList.add("comment");
        commentDiv.textContent = text;
        commentsSection.appendChild(commentDiv);
    }

    // Manejar el envío del comentario
    commentForm.addEventListener("submit", function (event) {
        event.preventDefault();
        const commentText = commentInput.value.trim();
        if (commentText !== "") {
            let comments = JSON.parse(localStorage.getItem("comments")) || [];
            comments.push(commentText);
            localStorage.setItem("comments", JSON.stringify(comments));
            displayComment(commentText);
            commentInput.value = "";
        }
    });

    // Cargar comentarios al iniciar
    loadComments();
});
