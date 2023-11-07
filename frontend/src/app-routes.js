import { HomePage, TasksPage, ProfilePage, GruposPage, PersonasPage, GrupoTiposPage } from './pages';
import { withNavigationWatcher } from './contexts/navigation';

const routes = [
    {
        path: '/tasks',
        element: TasksPage
    },
    {
        path: '/profile',
        element: ProfilePage
    },
    {
        path: '/home',
        element: HomePage
    },
    {
        path: '/grupos',
        element: GruposPage
    },
    {
        path: '/personas',
        element: PersonasPage
    },
    {
        path: '/grupotipo',
        element: GrupoTiposPage
    }
];

export default routes.map(route => {
    return {
        ...route,
        element: withNavigationWatcher(route.element, route.path)
    };
});
