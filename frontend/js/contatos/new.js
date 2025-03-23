import ContatoService from "../ContatoService.js";

document
  .getElementById("contactForm")
  .addEventListener("submit", (event) => submitContact(event));

const params = new URLSearchParams(window.location.search);
const clientId = params.get("id");

const cancelLink = document.getElementById("cancelLink");
cancelLink.href = `../show.html?id=${clientId}`;

async function submitContact(event) {
  event.preventDefault();
  const type = document.getElementById("type").value;
  const value = document.getElementById("value").value;
  const observation = document.getElementById("observation").value;

  const contactData = {
    tipo: type,
    valor: value,
    observacao: observation,
  };

  const response = await ContatoService.saveContact(clientId, contactData);

  if (response) {
    const errorList = document.getElementById("errorList");
    response.forEach((message) => {
      let li = document.createElement("li");
      li.innerText = message;
      errorList.appendChild(li);
    });
  }
}
