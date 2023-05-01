let dashboardContent = document.querySelector('.main-body');
let menuItems = document.querySelectorAll('ul li a');

const updateDashboardContent = (url) => {
    let httpRequest = new XMLHttpRequest();
    httpRequest.onreadystatechange = function() {
        if (this.readyState === 4 && this.status === 200)
            dashboardContent.innerHTML = this.responseText;
    };
    httpRequest.open("get", url, true);
    httpRequest.send();
};

menuItems.forEach(menuItem => {
    menuItem.addEventListener("click", (event) => {
        event.preventDefault();
        updateDashboardContent(menuItem.href);
    });
});