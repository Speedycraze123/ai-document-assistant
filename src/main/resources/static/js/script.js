const uploadButton = document.getElementById("uploadButton");
const documentInput = document.getElementById("documentInput");

uploadButton.addEventListener("click", function () {
    const file = documentInput.files[0];

    if (!file) {
        alert("Please select a PDF document first.");
        return;
    }

    alert("Selected document: " + file.name);
});