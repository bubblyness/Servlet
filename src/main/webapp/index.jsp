<!DOCTYPE html>
<html>
<head>
    <title>Exception Handling Example</title>
</head>
<body>
    <h2>Enter a Number</h2>
    <form action="calculate" method="post">
        <label for="number">Number1:</label>
        <input type="text" id="number" name="number">

        <select id = "operator" name="operator">
            <option value="+">+</option>
            <option value="-">-</option>
            <option value="/">/</option>
            <option value="*">*</option>
        </select>
        <label for="number2">Number2:</label>
        <input type="text" id="number2" name="number">
        <input type="submit" value="Submit">
    </form>
</body>
</html>

