let reg1 = /^[A-Za-zА-Яа-яЁё]{1,30}$/;
let reg2 = /^[1-9]{1}$|^[1-2]{1}[0-9]{1}$|^30$/;
let reg3 = /^(0|[1-9]\d{0,3})(\.[1-9]{1,2})?$/;

let inp1 = document.querySelector('#type');
let inp2 = document.querySelector('#age');
let inp3 = document.querySelector('#price');
let span1 = document.querySelector('.span1');
let span2 = document.querySelector('.span2');
let span3 = document.querySelector('.span3');



document.querySelector('.btn').onclick = function (e) {
    if (!validate(reg1, inp1.value)) {
        e.preventDefault();
        notValid(inp1, span1, 'Введите только буквы(не менее 1-го символа и не более 30-ти)');
    }
    if (!validate(reg2, inp2.value)) {
        e.preventDefault();
        notValid(inp2, span2, 'Введите возраст 1-30 лет');
    }
    if (!validate(reg3, inp3.value)) {
        e.preventDefault();
        notValid(inp3, span3, 'Минимальное значение 0.01$. Максимальное значение 9999.99 $');
    }
};

function validate(regex, inp) {
    return regex.test(inp);
}

function notValid(inp, el, mess) {
    inp.classList.add('is-invalid');
    el.innerHTML = mess;
}