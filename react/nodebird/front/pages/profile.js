import AppLayout from "../components/AppLayout";
import FollowList from "../components/FollowList";
import NicknameEditForm from "../components/NicknameEditForm";

const Profile = () => {
    const followerList = [{ nickname: '권호' }, { nickname: '권호1' }, { nickname: '권호2' }];
    const followingList = [{ nickname: '권호3' }, { nickname: '권호4' }, { nickname: '권호5' }];
    return (
        <>
            <header>
                <title>내 프로필 | NodeBird</title>
            </header>
            <AppLayout>
                <NicknameEditForm/>
                <FollowList header={ "팔로잉 목록" } data={ followingList } />
                <FollowList header={ "팔로워 목록" } data={ followerList } />
            </AppLayout>
        </>
    );
};

export default Profile;