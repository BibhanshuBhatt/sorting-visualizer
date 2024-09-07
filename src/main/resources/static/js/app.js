async function startSorting() {
    const algorithm = document.getElementById("algorithm").value;
    const size = parseInt(document.getElementById("size").value);
    const speed = parseInt(document.getElementById("speed").value);

    // Generate a random array of the specified size
    const array = Array.from({ length: size }, () => Math.floor(Math.random() * 100));

    // Send array to the backend for sorting
    const response = await fetch(`/api/sort/${algorithm}`, {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(array)
    });
    const result = await response.json();

    // Visualize sorting steps
    visualizeSorting(result.steps, speed);
}

function visualizeSorting(steps, speed) {
    const visualizer = document.getElementById("visualizer");
    visualizer.innerHTML = ''; // Clear previous visualization

    steps.forEach((step, index) => {
        setTimeout(() => {
            visualizer.innerHTML = ''; // Clear previous step
            step.forEach(value => {
                const bar = document.createElement('div');
                bar.className = 'bar';
                bar.style.height = `${value * 3}px`; // Scale height for visualization
                visualizer.appendChild(bar);
            });
        }, index * speed); // Set timeout based on the speed value
    });
}
