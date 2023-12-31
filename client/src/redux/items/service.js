const URL = "https://inventory-service-42x9.onrender.com/"

const getItems = async () => {
    const response = await fetch(URL + 'items/', {
        method: 'GET'
    })
        .then (res => res.json());

    return response;
};

const addItem = async (item) => {
    const response = await fetch(URL + 'items/', {
        method: 'POST',
        headers: {
            'Content-type': 'application/json'
        },
        body: JSON.stringify(item)
    })
        .then(res => res.json())
        .catch(err => {
            throw new Error(err.message)
        });

    return response;
}

const deleteItem = async (itemId) => {
    const response = await fetch(URL + `items/${itemId}`, {
        method: 'DELETE'
    })
        .then(res => {
            if (!res.ok) throw new Error(res.status);
        })
        .catch(err => {
            throw new Error(err.message);
        });

    return itemId;
}

const editItem = async (itemInfo) => {
    const {item} = itemInfo;

    const response = await fetch(URL + `items/`, {
        method: 'PATCH',
        headers: {
            'Content-type': 'application/json'
        },
        body: JSON.stringify(item)
    })
        .then(res => res.json())
        .catch(err => {
            throw new Error(err.message);
        });

    return response;
}

const sortItems = async (criterion) => {
    const response = fetch(URL + `items/sorted?by=${criterion}`, {
        method: 'GET'
    })
        .then(res => res.json())
        .catch(err => {
            throw new Error(err);
        });

    return response;
}

export default {
    getItems,
    addItem,
    deleteItem,
    editItem,
    sortItems,
};