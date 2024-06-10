import axios from "axios";

let nextId = 4;
let todos = [
    {
        id: 1,
        content: 'todo test 1',
        done: false,
    },
    {
        id: 2,
        content: 'Hello world',
        done: true,
    },
    {
        id: 3,
        content: 'TGC class',
        done: false,
    },
];

const getTodos = async () => {
    return new Promise((resolve, reject) => {
        axios.get('http://localhost:8081/todo')
            .then(res => {
                resolve(res.data);
            }).catch(e => {
            reject(e);
        });
    });
}


const addTodo = async (content, done) => {
    return new Promise((resolve, reject) => {
        axios.post('http://localhost:8081/todo', {content, done})
            .then(res => {
                resolve(res.data);
            }).catch(e => {
            reject(e);
        });
    });
}

const delTodo = async (id) => {
    return new Promise((resolve, reject) => {
        axios.delete('http://localhost:8081/todo/' + id)
            .then(res => {
                resolve(res.data);
            }).catch(e => {
            reject(e);
        });
    });
}

const updateTodo = async ({id, content, done}) =>{
    return new Promise((resolve, reject) => {
        const intDone = done ? 1 : 0;
        axios.put('http://localhost:8081/todo', {id, content, done: intDone})
            .then(res => {
                resolve(res.data);
            }).catch(e => {
            reject(e);
        });
    });
}

export {getTodos, addTodo, delTodo, updateTodo};