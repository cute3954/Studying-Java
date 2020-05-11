var users = [
	{id: 1, name: 'ID', age: 36},
	{id: 2, name: 'BJ', age: 32},
	{id: 3, name: 'JM', age: 32},
	{id: 4, name: 'PJ', age: 27},
	{id: 5, name: 'HA', age: 25},
	{id: 6, name: 'JE', age: 26},
	{id: 7, name: 'JI', age: 31},
	{id: 8, name: 'MP', age: 23}
];

/* 1. 命令型プログラミング */
// 1)　30歳以上のメンバーのみを絞り込んで配列に格納
var temp_users = [];
for (var i = 0; i < users.length; i++) {
	if (users[i].age >= 30) {
		temp_users.push(users[i]);
	}
}
console.log(temp_users);

// 2)　30歳以上のメンバーのnameを格納
var names = [];
for (var i = 0; i < temp_users.length; i++) {
	names.push(temp_users[i].name);
}
console.log(names);

// 3)　30歳未満のメンバーのみを絞り込んで配列に格納
var temp_users = [];
for (var i = 0; i < users.length; i++) {
	if (users[i].age < 30) {
		temp_users.push(users[i]);
	}
}
console.log(temp_users); 

// 4)　30歳未満のメンバーのageを格納
var ages = [];
for (var i = 0; i < temp_users.length; i++) {
	ages.push(temp_users[i].age);
}
console.log(ages);

/* 2. 関数型プログラミング */
// underscore.jsのfilter()、map()と同じ。
// 1)_filter
var over_30 = _filter(users, function(user) {return user.age >= 30;});
console.log(over_30);
var under_30 = _filter(users, function(user) {return user.age < 30;});
console.log(under_30);

// 2)_map
var names = _map(over_30, function(user) {
	return user.name;
})
console.log(names);
var ages = _map(under_30, function(user) {
	return user.age;
})
console.log(ages);

// 3)_curry
var add = _curry(function(a, b) {
	return a + b;
});

var add10 = add(10);
var add5 = add(5);

console.log(add10(5));
console.log(add(5)(3));
console.log(add5(3));
console.log(add(10)(3));
console.log(add(1, 2));

var sub = _curry(function(a, b) {
	return a - b;
})

console.log(sub(10, 5));
var sub10 = sub(10);
console.log(sub10(5));

// 4)_curryr
var sub = _curryr(function(a, b) {
	return a - b;
})

console.log(sub(10, 5));
var sub10 = sub(10);
console.log(sub10(5));

// 5)_get
var user1 = users[0];
console.log(_get(user1, 'name'));
console.log(_get('name')(user1));
// undefinedを返す
// console.log(_get(users[10], 'name'));

var get_name = _get('name');
console.log(get_name(user1));
console.log(get_name(users[5]));

console.log(
		_map(
			_filter(users, function(user) {return user.age >= 30;}),
			_get('name'))
);
console.log(
		_map(
			_filter(users, function(user) {return user.age < 30;}), 
			_get('age'))
);

console.clear();

// 6)_reduce
console.log(
	_reduce([1, 2, 3], add, 10)
);
console.log(
	_reduce([1, 2, 3], add)
);
console.log(
	_reduce([1, 2, 3, 4], add, 25)
);

// 7)_pipe
var f1 = _pipe(
	function(a) {return a + 1;}, 
	function(a) {return a * 2;},
	function(a) {return a * a;}
	);

console.log(f1(1));

// 8)_go
_go(1, 
	function(a) {return a + 1;}, 
	function(a) {return a * 2;},
	function(a) {return a * a;},
	console.log
);

var _map = _curryr(_map),
_filter = _curryr(_filter);

console.log(_map([1, 2, 3], function(val) {return val * 2;}));
console.log(_map(function(val) {return val * 2;})([1, 2, 3]));

_go(users,
	_filter(function(user) {return user.age >= 30;}),
	_map(_get('name')),
	console.log
);

_go(users,
	_filter(user => user.age < 30),
	_map(user => user.age),
	console.log
);

// 9)アロー関数
// 詳細は -> https://developer.mozilla.org/ja/docs/Web/JavaScript/Reference/Functions/Arrow_functions
var a = function(user) {return user.age >= 30;};
// ↓
var a = user => user.age >= 30;

var add = function(a, b) {return a + b;};
// ↓
var add = (a, b) => a + b;
// 中身が長くなる場合、波括弧で囲む
var add = (a, b) => {
	return a + b;
};
// objectリテラル式を返す場合、本体を丸括弧で囲む
var add = (a, b) => ({val: a + b});

// nullが入っていたら、エラーを出さず空の配列を返す。
_each(null, console.log);
console.log(_map(null, function(v) {return v;}));

_go(null,
	_filter(function(v) {return v % 2;}),
	_map(function(v) {return v * v;}),
	console.log);

console.log(_keys({name: 'ID', age: 33}));
console.log(_keys([1, 2, 3, 4]));
console.log(_keys(10));
// nullが入ったらエラーを出す
console.log(_keys(null));

_each({
	13: 'ID',
	19: 'HD',
	29: 'YD'
}, function(name) {
	console.log(name);
});
console.log(_map({
	13: 'ID',
	19: 'HD',
	29: 'YD'
}, function(name) {
	return name.toLowerCase();
}));
_go(users,
	_map(function(user) {
		return user.name;
	}),
	_map(function(name) {
		return name.toLowerCase();
	}),
console.log);