-- 1. Mosques
CREATE TABLE mosques (
    id BIGINT IDENTITY(1,1) PRIMARY KEY,
    name NVARCHAR(150) NOT NULL,
    location NVARCHAR(255),
    image_url NVARCHAR(500),
    created_at DATETIME2 DEFAULT GETDATE()
);

-- 2. Users
CREATE TABLE users (
    id BIGINT IDENTITY(1,1) PRIMARY KEY,
    mosque_id BIGINT NULL,
    name NVARCHAR(100) NOT NULL,
    user_name NVARCHAR(100) NOT NULL UNIQUE,
    password NVARCHAR(255) NOT NULL,
    phone_number NVARCHAR(20),
    image_url NVARCHAR(500),
    CONSTRAINT FK_users_mosques FOREIGN KEY (mosque_id) REFERENCES mosques(id) ON DELETE SET NULL
);

-- 3. Activities
CREATE TABLE activities (
    id BIGINT IDENTITY(1,1) PRIMARY KEY,
    mosque_id BIGINT NOT NULL,
    title NVARCHAR(150) NOT NULL,
    description NVARCHAR(MAX),
    created_at DATETIME2 DEFAULT GETDATE(),
    CONSTRAINT FK_activities_mosques FOREIGN KEY (mosque_id) REFERENCES mosques(id) ON DELETE CASCADE
);

-- 4. Activity Subscriptions
CREATE TABLE activity_subscriptions (
    id BIGINT IDENTITY(1,1) PRIMARY KEY,
    activity_id BIGINT NOT NULL,
    user_id BIGINT NOT NULL,
    created_at DATETIME2 DEFAULT GETDATE(),
    CONSTRAINT UQ_user_activity UNIQUE (activity_id, user_id),
    CONSTRAINT FK_subscriptions_activities FOREIGN KEY (activity_id) REFERENCES activities(id) ON DELETE CASCADE,
    CONSTRAINT FK_subscriptions_users FOREIGN KEY (user_id) REFERENCES users(id)
);