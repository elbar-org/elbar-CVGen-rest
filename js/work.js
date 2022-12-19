let addWorkBtn = document.querySelector(".addWork");
let works = document.querySelector(".works");

function addWork() {
    let id = works.lastElementChild.id;
    console.log(id);
    let substring = id.substring(id.length - 1, id.length);
    let newId = parseInt(substring) + 1;

    let workHtml = "<p>Click \"Insert\" to insert a paragraph after the header.</p>";
    let work = " <div class=\"card work mb-3\" id=\"work-" + newId + "\">\n" +
        "                    <div class=\"card-body mb-3\">\n" +
        "                        <div class=\"mb-3\">\n" +
        "                            <label for=\"exampleWorkPosition" + newId + "\" class=\"form-label\">Position</label>\n" +
        "                            <input type=\"text\" class=\"form-control mb-3\" id=\"exampleWorkPosition" + newId + "\">\n" +
        "                            <div class=\"row mb-3\">\n" +
        "                                <div class=\"col-6\">\n" +
        "                                    <label for=\"exampleWorkCompany" + newId + "\" class=\"form-label\">Company</label>\n" +
        "                                    <input type=\"text\" class=\"form-control\" id=\"exampleWorkCompany" + newId + "\">\n" +
        "                                </div>\n" +
        "                                <div class=\"col-6\">\n" +
        "                                    <label for=\"exampleWorkLocation" + newId + "\" class=\"form-label\">Location</label>\n" +
        "                                    <input type=\"text\" class=\"form-control\" id=\"exampleWorkLocation" + newId + "\">\n" +
        "                                </div>\n" +
        "                            </div>\n" +
        "                            <div class=\"row mb-3\">\n" +
        "                                <div class=\"col-6\">\n" +
        "                                    <label for=\"exampleWorkStartDate" + newId + "\" class=\"form-label\">Start Date</label>\n" +
        "                                    <input type=\"date\" class=\"form-control\" id=\"exampleWorkStartDate" + newId + "\">\n" +
        "                                </div>\n" +
        "                                <div class=\"col-6\">\n" +
        "                                    <label for=\"exampleWorkEndDate" + newId + "\" class=\"form-label\">End Date</label>\n" +
        "                                    <input type=\"date\" class=\"form-control\" id=\"exampleWorkEndDate" + newId + "\">\n" +
        "                                </div>\n" +
        "                            </div>\n" +
        "                            <div class=\"mb-3\">\n" +
        "                                <label for=\"exampleWorkDescription" + newId + "\" class=\"form-label\">Description</label>\n" +
        "                                <textarea class=\"form-control\" rows=\"4\" id=\"exampleWorkDescription" + newId + "\"></textarea>\n" +
        "                            </div>\n" +
        "                        </div>\n" +
        "                        <a href=\"#\" class=\"btn btn-dark\" onclick=\"removeWork('work-" + newId + "')\">Delete</a>\n" +
        "                    </div>\n" +
        "                </div>";
}

addWorkBtn.addEventListener("click", addWork);

