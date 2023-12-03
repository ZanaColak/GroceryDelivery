const productOrderApiUrl = '/order';
async function fetchProductOrders() {
    const response = await fetch(productOrderApiUrl);
    const productOrders = await response.json();

    const tableBody = document.getElementById('productOrderTableBody');
    tableBody.innerHTML = '';

    productOrders.forEach(productOrder => {
        const row = `<tr>
                        <td>${productOrder.productOrderId}</td>
                        <td>${productOrder.quantity}</td>
                        <td>
                            <button onclick="updateProductOrder(${productOrder.productOrderId})">Update</button>
                            <button onclick="deleteProductOrder(${productOrder.productOrderId})">Delete</button>
                        </td>
                    </tr>`;
        tableBody.innerHTML += row;
    });
}

async function addProductOrder() {
    const quantity = document.getElementById('quantity').value;
    const response = await fetch(productOrderApiUrl, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({ quantity }),
    });

    if (response.ok) {
        fetchProductOrders();
    } else {
        alert('Failed to add product order.');
    }
}

async function updateProductOrder(productOrderId) {
    const quantity = prompt('Enter new quantity:');

    if (quantity !== null) {
        const response = await fetch(`${productOrderApiUrl}/${productOrderId}`, {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({ quantity }),
        });

        if (response.ok) {
            fetchProductOrders();
        } else {
            alert('Failed to update product order.');
        }
    }
}

async function deleteProductOrder(productOrderId) {
    const response = await fetch(`${productOrderApiUrl}/${productOrderId}`, {
        method: 'DELETE',
    });

    if (response.ok) {
        fetchProductOrders();
    } else {
        alert('Failed to delete product order.');
    }
}

fetchProductOrders();
