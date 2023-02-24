const top_btns = document.querySelectorAll("#top_panel > div > span");

const input1 = document.querySelector("#input1 > textarea");
const input2 = document.querySelector("#input2 > textarea");
const output = document.querySelector("#output > textarea");
const input1_lbl = document.querySelector("#input1_label");
const input2_lbl = document.querySelector("#input2_label");
const output_lbl = document.querySelector("#output_label");
const submit_btn = document.querySelector("#btn");

let active_state = 0;

const State = {
    MINIFY: 0,
    PPRINT: 1,
    WOFIELDS: 2,
    OFIELDS: 3,
    COMPARE: 4,
    TOXML: 5,
    TOCSV: 6
}

function change_state(){
    switch(active_state){
        case State.MINIFY:
            input1.value = "";
            input1.placeholder = "Input your JSON to minify here!";
            input2.disabled = false;
            input2.placeholder = "Don't look at me >:("
            input2.value = "";
            input2.disabled = true;
            input1_lbl.innerHTML = "JSON goes here:"
            input2_lbl.innerHTML = "Not used"
            break;
        case State.PPRINT:
            input1.value = "";
            input1.placeholder = "Input your JSON to pretty print here!";
            input2.disabled = false;
            input2.placeholder = "Don't look at me >:("
            input2.value = "";
            input2.disabled = true;
            input1_lbl.innerHTML = "JSON goes here:"
            input2_lbl.innerHTML = "Not used"
            break;
        case State.WOFIELDS:
            input1.value = "";
            input1.placeholder = "Input your JSON here!";
            input2.disabled = false;
            input2.placeholder = "Input fields that you want to dismiss here. Comma separate them!"
            input2.value = "";
            input2.disabled = false;
            input1_lbl.innerHTML = "JSON goes here:"
            input2_lbl.innerHTML = "Fields to dismiss:"
            break;
        case State.OFIELDS:
            input1.value = "";
            input1.placeholder = "Input your JSON here!";
            input2.disabled = false;
            input2.placeholder = "Input fields that you want to show here. Comma separate them!"
            input2.value = "";
            input2.disabled = false;
            input1_lbl.innerHTML = "JSON goes here:"
            input2_lbl.innerHTML = "Fields to show:"
            break;
        case State.COMPARE:
            input1.value = "";
            input1.placeholder = "Input your first JSON to compare here!";
            input2.disabled = false;
            input2.value = "";
            input2.placeholder = "Input your second JSON to compare here!";
            input2.disabled = false;
            input1_lbl.innerHTML = "First JSON goes here:"
            input2_lbl.innerHTML = "Aaaand the second JSON goes here:"
            break;
        case State.TOXML:
            input1.value = "";
            input1.placeholder = "Input your JSON that you want to convert to XML here!";
            input2.disabled = false;
            input2.placeholder = "Don't look at me >:("
            input2.value = "";
            input2.disabled = true;
            input1_lbl.innerHTML = "JSON goes here:"
            input2_lbl.innerHTML = "Not used"
            break;
        case State.TOCSV:
            input1.value = "";
            input1.placeholder = "Input your JSONs that you want to convert to CSV here! Comma separate them! They should have the same fields, but it is up to you!";
            input2.disabled = false;
            input2.placeholder = "Don't look at me >:("
            input2.value = "";
            input2.disabled = true;
            input1_lbl.innerHTML = "JSON goes here:"
            input2_lbl.innerHTML = "Not used"
            break;
    }
}

change_state();
top_btns.forEach(el => {
    el.addEventListener("click", ()=>{
        top_btns.forEach(element =>{
            element.parentElement.classList.remove("active");
        })

        el.parentElement.classList.add("active");
        active_state = Array.prototype.indexOf.call(top_btns, el);
        change_state();
        return;
    })
});
submit_btn.addEventListener("click", ()=>{
    submit_btn.classList.add("is_active");
    setTimeout(() => {
        submit_btn.classList.remove("is_active"); 
    }, 800)
    switch(active_state){
        case State.MINIFY:
            fetch("http://" + window.location.hostname + ":8080/minify",{
                method: 'POST',
                body: input1.value
            })
            .then((response) => response.text())
            .then((text) => output.value = text);
            break;
        case State.PPRINT:
            fetch("http://" + window.location.hostname + ":8080/prettyprint",{
                method: 'POST',
                body: input1.value
            })
            .then((response) => response.text())
            .then((text) => output.value = text);
            break;
        case State.WOFIELDS:
            fetch("http://" + window.location.hostname + ":8080/withoutfields?items=" + input2.value,{
                method: 'POST',
                body: input1.value
            })
            .then((response) => response.text())
            .then((text) => output.value = text);        
            break;
        case State.OFIELDS:
            fetch("http://" + window.location.hostname + ":8080/withselected?items=" + input2.value,{
                method: 'POST',
                body: input1.value
            })
            .then((response) => response.text())
            .then((text) => output.value = text);        
            break;
        case State.COMPARE:
            fetch("http://" + window.location.hostname + ":8080/compare",{
                method: 'POST',
                body: input1.value + "," + input2.value
            })
            .then((response) => response.text())
            .then((text) => output.value = text);        
            break;
        case State.TOXML:
            fetch("http://" + window.location.hostname + ":8080/xml",{
                method: 'POST',
                body: input1.value
            })
            .then((response) => response.text())
            .then((text) => output.value = text);        
            break;
        case State.TOCSV:
            fetch("http://" + window.location.hostname + ":8080/csv",{
                method: 'POST',
                body: "[" + input1.value + "]"
            })
            .then((response) => response.text())
            .then((text) => output.value = text);        
            break;
    }
})
