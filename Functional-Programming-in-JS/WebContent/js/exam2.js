var products = [
	{
		is_selected: true,
		name: "tshirt",
		price: 10,
		sizes: [
			{name: "L", quantity: 2, price: 0},
			{name: "XL", quantity: 3, price: 0},
			{name: "2XL", quantity: 2, price: 2}
		]
	},
	{
		is_selected: true,
		name: "hoodie",
		price: 21,
		sizes: [
			{name: "L", quantity: 3, price: -1},
			{name: "2XL", quantity: 10, price: 2}
		]
	},
	{
		is_selected: false,
		name: "sweatshirt",
		price: 16,
		sizes: [
			{name: "L", quantity: 4, price: 0}
		]
	},
];

var total_quantity = _.reduce(function(tq, product) {
	return _.reduce(product.sizes, function(tq, size) {
		return tq + size.quantity;
	}, tq);
}, 0);

_.go(products,
	total_quantity,
	console.log);

_.go(products,
	_.filter(_get('is_selected')),
	total_quantity,
	console.log);

var total_price = _.reduce(function(tp, product) {
	return _.reduce(product.sizes, function(tp, size) {
		return tp + size.quantity * (product.price + size.price);
	}, tp);
}, 0);

_.go(products,
	total_price,
	console.log);

_.go(products,
	_.filter(_get('is_selected')),
	total_price,
	console.log);