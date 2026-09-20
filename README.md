# 💊 GetMedBD

### Multi-Vendor Online Pharmacy Marketplace

GetMedBD is an Android-based multi-vendor pharmacy marketplace designed to connect customers with verified pharmacies. Customers can search for medicines, compare available pharmacies, upload prescriptions, place orders, make payments, and track their orders.

The platform has four main portals:

* 👤 **Customer**
* 🏪 **Shop / Pharmacy**
* 🛠️ **Admin**
* 👑 **SuperAdmin**

---

## 🚀 Main Features

### 👤 Customer

* Create account and login
* Search and browse medicines
* View medicine details
* Compare medicines from different pharmacies
* Find nearby pharmacies
* Upload prescriptions
* AI-assisted prescription analysis
* Add medicines to cart
* Place orders
* Online payment
* Order history
* Order tracking
* Pharmacy ratings and reviews
* Notifications
* Saved addresses and favourites

### 🏪 Shop / Pharmacy

* Pharmacy registration
* Pharmacy verification
* Manage pharmacy profile
* Add and manage medicines
* Manage inventory and stock
* Manage prices
* Receive customer orders
* Process orders
* Handle prescription orders
* View sales and earnings
* Manage reviews
* Notifications

### 🛠️ Admin

* Manage customers
* Review and verify pharmacies
* Manage medicines and categories
* Manage orders
* Monitor prescriptions
* Manage payments
* Handle complaints and disputes
* Manage pharmacy activity
* View marketplace reports and analytics

### 👑 SuperAdmin

* Manage Admin accounts
* Manage Admin permissions
* Control platform settings
* Manage marketplace configuration
* View system activity
* View audit logs
* Manage critical platform operations

---

## 🛠️ Technology

* **Android**
* **Java**
* **Android Studio**
* **Supabase**

  * Authentication
  * PostgreSQL Database
  * Storage
  * Realtime
* **Firebase Cloud Messaging**
* **Google Maps**
* **AI API**
* **Git**
* **GitHub**

No VPS or Docker is required for the initial project setup.

---

# 📥 Team Setup

Before starting development, everyone must have the required project environment.

## 1. Download the Required Software

Download and install the required software from the **Google Drive provided by the team**.

Make sure the required Android/Java development setup provided by the team is installed correctly.

> If your required setup is already installed and working, **skip this section**.

---

# 🔧 2. Setup the Project

After installing the required software, clone the project from GitHub.

Repository:

`https://github.com/Naim-006/GetMediBD.git`

Open **Git Bash / Terminal** and run:

```bash
git clone https://github.com/Naim-006/GetMediBD.git
```

Then enter the project folder:

```bash
cd GetMediBD
```

Open the cloned project in **Android Studio**.

> **Do not create a new project.**
>
> Open the project that you cloned from GitHub.

---

# 👥 3. Repository Access

All **5 team members have already been added as collaborators** to the GitHub repository.

Therefore:

* No fork is required.
* Do not create another repository.
* Clone the original repository directly.
* Everyone works on the same repository using their assigned branch.

---

# 🌿 4. Branch Structure

The repository contains:

```text
main
│
├── branch-1-naim
├── branch-2-ajmine
├── branch-3-rezuan
├── branch-4-asha
└── branch-5-jhuma
```

### `main`

The `main` branch is the **stable branch**.

Do not directly develop or push your work to `main`.

### Your Assigned Branch

Each team member has one dedicated branch.

You should work only on your assigned branch unless the team leader gives different instructions.

---

# 🔄 5. Before Starting Your Work

First make sure you are on your assigned branch:

```bash
git checkout your-branch
```

Then get the latest changes:

```bash
git pull
```

Example:

```bash
git checkout member-1
git pull
```

Always pull the latest changes before starting new work.

---

# 💻 6. Work on Your Feature

Now work normally in Android Studio.

For example:

```text
Create UI
↓
Write Java code
↓
Connect Supabase
↓
Test the feature
↓
Fix issues
```

Try to keep your changes related to the feature you are working on.

---

# 📌 7. Check Your Changes

After finishing your work, check what changed:

```bash
git status
```

Review the changes before committing.

---

# ➕ 8. Add Your Changes

```bash
git add .
```

---

# 💾 9. Commit Your Changes

Create a clear commit message describing what you changed.

Example:

```bash
git commit -m "Add customer login screen"
```

Other examples:

```bash
git commit -m "Add pharmacy registration"
```

```bash
git commit -m "Implement medicine search"
```

```bash
git commit -m "Fix order calculation"
```

Avoid messages such as:

```text
update
changes
done
final
test
```

Use a message that explains the actual change.

---

# ⬆️ 10. Push Your Branch

Push your changes to your assigned branch:

```bash
git push
```

If it is the first push for the branch:

```bash
git push -u origin your-branch
```

---

# 🔀 11. Create a Pull Request

After pushing your completed feature:

1. Go to the GitHub repository.
2. Open your branch.
3. Click **Compare & pull request**.
4. Set the destination branch to:

```text
main
```

5. Write a short description of your changes.
6. Create the Pull Request.
7. Request a review from the appropriate team member/team leader.

### Important

Do **not** directly merge your own Pull Request unless the team has agreed to do so.

The Pull Request should be reviewed first.

```text
Your Branch
     │
     │ Push
     ▼
  GitHub
     │
     │ Pull Request
     ▼
  Code Review
     │
     │ Approved
     ▼
   main
```

---

# 🔄 12. After Your Pull Request Is Merged

Once your changes are merged into `main`, update your local repository before starting another feature.

```bash
git checkout main
git pull
```

Then return to your assigned branch:

```bash
git checkout your-branch
```

Get the latest `main` changes into your branch:

```bash
git merge main
```

If there are conflicts, resolve them before continuing your work.

---

# ⚠️ Important Git Rules

### ❌ Do not directly push to `main`

Always use your assigned branch.

### ❌ Do not force push

Avoid:

```bash
git push --force
```

unless the team leader specifically asks you to do it.

### ❌ Do not delete another member's branch

### ❌ Do not overwrite another member's work

### ❌ Do not commit secrets

Never commit:

* API keys
* Passwords
* Access tokens
* Database credentials
* Private keys
* `.env` files containing secrets

### ✅ Pull before starting work

```bash
git pull
```

### ✅ Commit regularly

Don't wait until the entire project is finished before committing.

### ✅ Use meaningful commit messages

Explain what your commit actually changes.

### ✅ Test before creating a Pull Request

Make sure your feature works before asking others to review it.

---

# 📋 Daily Git Workflow

For normal development, remember this:

```bash
git checkout your-branch
git pull

# Work on your feature...

git status
git add .
git commit -m "Describe your changes"
git push
```

Then create a **Pull Request → Review → Merge into `main`**.

---

# 🌳 Team Workflow

```text
                    main
                     │
       ┌─────────────┼─────────────┐
       │             │             │
   Member 1      Member 2      Member 3
       │             │             │
       │             │             │
      PR            PR            PR
       │             │             │
       └─────────────┼─────────────┘
                     │
                  Review
                     │
                     ▼
                    main

       + Member 4
       + Member 5
```

Each member develops independently on their assigned branch.

All completed features go through **Pull Request + Code Review** before being merged into `main`.

---

# 📁 Project Structure

The project will generally follow the Android project structure:

```text
GetMediBD/
│
├── app/
│   └── src/
│
├── gradle/
├── build.gradle
├── settings.gradle
└── README.md
```

The exact structure may change as development progresses.

---

# 🔐 Backend

GetMedBD uses **Supabase** as the backend platform.

It will provide:

```text
Android App
     │
     └── Supabase
          ├── Authentication
          ├── PostgreSQL Database
          ├── Storage
          └── Realtime
```

Additional services such as Firebase, Maps, payment services, and AI services may be integrated as development progresses.

---

# 🚧 Development Roadmap

The project will be developed progressively.

### Phase 1

* Project setup
* Authentication
* User roles
* Basic UI
* Database structure

### Phase 2

* Customer features
* Pharmacy features
* Medicine catalog
* Inventory
* Cart and orders

### Phase 3

* Prescription system
* AI-assisted prescription processing
* Payments
* Notifications
* Pharmacy verification

### Phase 4

* Admin and SuperAdmin management
* Reports and analytics
* Reviews and ratings
* Delivery features
* Advanced marketplace features

---

# 📌 Repository

**GitHub:**
`https://github.com/Naim-006/GetMediBD.git`

---

## 💊 GetMedBD

**One marketplace. Multiple pharmacies. Better access to medicines.**
