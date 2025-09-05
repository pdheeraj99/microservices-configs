import React, { useState } from 'react';
import './App.css';

function App() {
    const [data, setData] = useState(null);
    const [error, setError] = useState(null);

    const fetchData = async (url) => {
        try {
            const response = await fetch(url);
            if (!response.ok) {
                throw new Error(`HTTP error! status: ${response.status}`);
            }
            const result = await response.json();
            setData(result);
            setError(null);
        } catch (e) {
            setError(e.message);
            setData(null);
        }
    };

    const fetchProducts = () => {
        fetchData('http://localhost:8000/products');
    };

    const fetchOffers = () => {
        fetchData('http://localhost:8000/offer');
    };

    return (
        <div className="App">
            <header className="App-header">
                <h1>Microservices Frontend</h1>
                <div className="button-container">
                    <button onClick={fetchProducts}>Fetch Products</button>
                    <button onClick={fetchOffers}>Fetch Offers</button>
                </div>
                <div className="data-display">
                    {error && <pre className="error">Error: {error}</pre>}
                    {data && <pre>{JSON.stringify(data, null, 2)}</pre>}
                </div>
            </header>
        </div>
    );
}

export default App;
