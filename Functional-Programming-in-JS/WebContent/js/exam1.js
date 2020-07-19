var users = [
	{id: 101, name: 'ID'},
	{id: 102, name: 'BJ'},
	{id: 103, name: 'PJ'},
	{id: 104, name: 'HA'},
	{id: 105, name: 'JE'},
	{id: 106, name: 'JI'}
];

var posts = [
	{id: 201, body: 'content1', user_id: 101},
	{id: 202, body: 'content2', user_id: 102},
	{id: 203, body: 'content3', user_id: 103},
	{id: 204, body: 'content4', user_id: 102},
	{id: 205, body: 'content5', user_id: 101}
];

var comments = [
	{id: 301, body: 'comment1', user_id: 105, post_id: 201},
	{id: 302, body: 'comment2', user_id: 104, post_id: 201},
	{id: 303, body: 'comment3', user_id: 104, post_id: 202},
	{id: 304, body: 'comment4', user_id: 105, post_id: 203},
	{id: 305, body: 'comment5', user_id: 106, post_id: 203},
	{id: 306, body: 'comment6', user_id: 106, post_id: 204},
	{id: 307, body: 'comment7', user_id: 102, post_id: 205},
	{id: 308, body: 'comment8', user_id: 103, post_id: 204},
	{id: 309, body: 'comment9', user_id: 103, post_id: 202},
	{id: 310, body: 'comment10', user_id: 105, post_id: 201}
];

// 課題1
function posts_by(attr) {
	return _.where(posts, attr);
}
var comments_by_posts = _.pipe(
	_.pluck('id'),
	function (post_ids) {
		return _.filter(comments, function(comment) {
			return _.contains(post_ids, comment.post_id)
		})
	}	
);
var f1 = _.pipe(posts_by, comments_by_posts);
console.log(f1({user_id: 101}));

// 課題2
var comments_to_user_names = _.map(function(comment) {
	return _.find(users, function(user) {
		return user.id == comment.user_id;
	}).name;
});
var f2 = _.pipe(f1, comments_to_user_names, _.uniq);
console.log(f2({user_id: 101}));

// 課題3
var f3 = _.pipe(f1, comments_to_user_names, _.count_by);
console.log(f3({user_id: 101}));

// 課題4
_.go(
	_.where(comments, {user_id: 105}),
	_.pluck('post_id'),
	_.uniq,
	function(post_ids) {
		return _.filter(posts, function(post) {
			return _.contains(post_ids, post.id);
		})
	},
	console.log
);

// 課題5 users + posts + comments
var users2 = _.index_by(users, 'id');
function find_user_by_id (user_id) {
	return users2[user_id];
}

var comments2 = _.go(
	comments,
	_.map(function(comment) {
		return _.extend({
			user: users2[comment.user_id]
		}, comment);
	}),
	_.group_by('post_id')
);
console.log(comments2);

var posts2 = _.go(
	posts,
	_.map(function(post) {
		return _.extend({
			comments: comments2[post.id] || [],
			user: users2[post.user_id]
		}, 
		post);
	})
);
		
var posts3 = _.group_by(posts2, 'user_id');
console.log(posts3);

var users3 = _.map(users2, function(user) {
	return _.extend({
		posts: posts3[user.id] || []
	},user);
})
console.log(users3);
// JSON.stringify(user3);

// 課題 5.1
var user = users3[0];
_.go(user.posts,
	_.pluck('comments'),
	_.flatten,
	console.log
);
console.log(_.deep_pluck(user, 'posts.comments'));

// 課題 5.2
_.go(user.posts,
	_.pluck('comments'),
	_.flatten,
	_.pluck('user'),
	_.pluck('name'),
	_.uniq,
	console.log
);
_.go(user, _.deep_pluck('posts.comments.user.name'), _.uniq, console.log);

// 課題 5.3
_.go(user.posts,
	_.pluck('comments'),
	_.flatten,
	_.pluck('user'),
	_.pluck('name'),
	_.count_by,
	console.log
);
_.go(user, _.deep_pluck('posts.comments.user.name'), _.count_by, console.log);

// 課題 5.4
console.log(
	_.filter(posts2, function(post) {
		return _.find(post.comments, function(comment) {
			return comment.user_id == 105;
		})
	})
);